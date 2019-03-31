package Addr;

public class Addr {
    private static String ip_address = "localhost:8888/yummy";
    // 미디어젠 * 192.168.1.67
    //  local   localhost:8888/yummy

    public static void setIP(String ip) {
        ip_address = ip;
    }

    public static String getIP() {
        return "http://" + ip_address + "/";
    }
}
