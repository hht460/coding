package thread.alternateprint;

public class AlternatePrint {
    public static void main(String[] args) {
        ThreadOne threadOne = new ThreadOne("奇数线程");
        ThreadTwo threadTwo = new ThreadTwo("偶数线程");
        // 启动两个线程
        threadOne.start();
        threadTwo.start();
    }
}
