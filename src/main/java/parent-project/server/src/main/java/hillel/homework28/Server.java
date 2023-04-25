package hillel.homework28;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

public class Server
{
    private final int port;
    private final Map<String, ClientHandler> clients;

    public Server(int port) {
        this.port = port;
        this.clients = new ConcurrentHashMap<>();
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущено на порту " + port);
            while (true) {
                System.out.println("JDEM PODKL");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Ktoto podkl");
                System.out.println("sozdaem novogo klienta");
                System.out.println("ispolzuem novogo klienta");

                new Thread(
                        new ClientHandler(
                                clientSocket,
                                this,
                                Integer.toString(this.clients.size() + 1)
                        )
                ).start();
                System.out.println("sozdali noviy klineskiy thread");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addClient(String name, ClientHandler clientHandler) {
        System.out.println(clients.size());
        clients.put(name, clientHandler);
        System.out.println(clients.size());
        sendAllClients("SERVER", name + " успішно підключився.");
    }

    public void removeClient(String name) {
        clients.remove(name);
        sendAllClients("SERVER", name + " відключився.");
    }

    public void sendAllClients(String sender, String message) {
        System.out.println(this.clients.size());
//        for(ClientHandler client : this.clients.values()){
//            System.out.println(client);
//            try {
//                client.sendMessage("[" + sender + "] " + message + " час підключеня " + client.getConnectionTime());
//                System.out.println("Send");
//
//
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
        this.clients.forEach((name, clientHandler) -> {
            try {
                clientHandler.sendMessage ("[" + sender + "] " + message + " час підключеня " + clientHandler.getConnectionTime());


            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        });
    }

    public static void main( String[] args ) {
        String rootPath = FileSystems.getDefault().getPath("").toAbsolutePath().toString();
        String appConfigPath = rootPath + "/src/main/java/parent-project/app.properties";
        Properties appProps = new Properties();
        try {
            appProps.load(Files.newInputStream(Paths.get(appConfigPath)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int appPort = Integer.parseInt(appProps.getProperty("port"));
        Server server = new Server(appPort);
        server.start();
        File serverFilesDir = new File("server_files");
        if (!serverFilesDir.exists()) {
            serverFilesDir.mkdir();
        }
    }
}
