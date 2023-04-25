package hillel.homework28;

import java.io.*;
import java.net.Socket;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

class ClientHandler extends Thread {
    private final Socket clientSocket;
    private final Server server;
    private final String name;
    private DataInputStream reader;

    public String getConnectionTime() {
        return connectionTime;
    }

    private DataOutputStream writer;

    private String connectionTime;

    public ClientHandler(Socket clientSocket, Server server, String clientId) {
        this.clientSocket = clientSocket;
        this.server = server;
        this.name = "client-" + clientId;
        this.connectionTime = LocalDateTime.now().toString();
    }

    @Override
    public void run() {
        try {
            try {
                reader = new DataInputStream(clientSocket.getInputStream());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                writer = new DataOutputStream(clientSocket.getOutputStream());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            server.addClient(name, this);

            while (true) {
                String message = null;
                try {
                    message = reader.readUTF();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(message);
                if (message.equals("Start upload file")) {
                    String marker = null;
                    File uploadedFile = null;
                    Integer fileSize = null;
                    while (true) {
                        try {
                            marker = reader.readUTF();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        if (marker.startsWith("fileName")) {
                            String filename = marker.replace("fileName", "");
                            System.out.println("file name: " + filename);
                            uploadedFile = new File("." + File.separator + "files"
                                    + File.separator + filename);

                            uploadedFile.getParentFile().mkdirs();
                        } else if (marker.startsWith("fileSize")) {
                            String value = marker.replace("fileSize", "");
                            fileSize = Integer.valueOf(value);
                            System.out.println("file size: " + fileSize);
                        } else if (marker.equals("fileBytes")) {

                            try {
                                assert uploadedFile != null;
                                try (FileOutputStream fos = FileUtils.openOutputStream(uploadedFile)) {

                                    int bytesCountReaded;
                                    int allBytesCountReaded = 0;

                                    byte[] buffer = IOUtils.byteArray(fileSize);

                                    while (-1 != (bytesCountReaded = reader.read(buffer))) {

                                        fos.write(buffer, 0, bytesCountReaded);

                                        allBytesCountReaded += bytesCountReaded;

                                        if (allBytesCountReaded == fileSize) {
                                            break;
                                        }
                                    }
                                }
                            } catch (Throwable e) {
                                e.printStackTrace();
                                System.err.println(e.toString());
                                throw e;
                            }
                        } else if (marker.equals("upload finished")) {
                            System.out.println("upload finished");
                            break;
                        } else {
                            System.out.println("Uggg");
                        }
                    }


                } else {
//                    System.out.println("Test");
                    System.out.println(message);
                    System.out.println("OK");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            server.removeClient(name);
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendMessage(String message) throws IOException {
        this.writer.writeUTF(message);
    }
}



