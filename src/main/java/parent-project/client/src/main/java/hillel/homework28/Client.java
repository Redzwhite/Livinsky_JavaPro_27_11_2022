package hillel.homework28;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.Scanner;

public class Client {
    private final String host;
    private final int port;
    private Socket socket;
    private static DataInputStream reader;
    private DataOutputStream writer;

    public Client(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void connect() {
        try {
            socket = new Socket();
            socket.connect(new InetSocketAddress(InetAddress.getByName(this.host), this.port));
            reader = new DataInputStream(socket.getInputStream());
            writer = new DataOutputStream(socket.getOutputStream());


            new Thread(() -> {
                try {
                    String message = reader.readUTF();
                    System.out.println(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String message) throws IOException {
        writer.writeUTF(message);
    }

    public void disconnect() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendFile(String filePath) {
        try {
            File file = new File(filePath);
            byte[] fileBytes = new byte[(int) file.length()];
            writer.writeUTF("Start upload file");
            writer.writeUTF("fileName" + file.getName());
            writer.writeUTF("fileSize" + Integer.toString(fileBytes.length));
            writer.writeUTF("fileBytes");
            try (FileInputStream fis = FileUtils.openInputStream(file)) {
                IOUtils.copy(fis, writer);
            } catch (Throwable e) {
                e.printStackTrace();
                System.out.println("Error");
                throw e;
            } finally {
                System.out.println("Uploaded");
            }
            writer.writeUTF("upload finished");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        String rootPath = FileSystems.getDefault().getPath("").toAbsolutePath().toString();
        String appConfigPath = rootPath + "/src/main/java/parent-project/app.properties";
        Properties appProps = new Properties();
        try {
            appProps.load(Files.newInputStream(Paths.get(appConfigPath)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int appPort = Integer.parseInt(appProps.getProperty("port"));
        Client client = new Client("0.0.0.0", appPort);
        client.connect();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String serverMsg = reader.readUTF();
            if(serverMsg != null){
                System.out.println(serverMsg);
            } else if(scanner.hasNext()){
                String message = scanner.nextLine();

                if (message.startsWith("-exit")) {
                    System.out.println("EXIT");
                    client.disconnect();
                    break;
                } else if (message.startsWith("-file")) {
                    System.out.println("FILE");
                    client.sendFile(message.substring(6).trim());
                } else {
                    System.out.println("SEND MSG");
                    client.sendMessage(message);
                }
            } else {
                continue;
            }
        }
        scanner.close();
    }
}
