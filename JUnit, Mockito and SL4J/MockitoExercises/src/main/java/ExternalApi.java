public interface ExternalApi {

    String getData();

    String getUser(String name);

    void sendMessage(String msg);

    void connect();

    void disconnect();

}