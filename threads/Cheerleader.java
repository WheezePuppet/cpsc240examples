
class Cheerleader implements Runnable {

    private String team;
    private int delay;

    Cheerleader(String t, int d) {
        team = t;
        delay = d;
    }

    public void run() {
        for (int i=0; i<5; i++) {
            System.out.println("Go " + team + "!");
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                System.out.println("Wake up " + team);
            }
        }
    }

    public static void main(String args[]) {
        Cheerleader c1 = new Cheerleader("Redskins",500);
        Cheerleader c2 = new Cheerleader("Giants",300);
        Cheerleader c3 = new Cheerleader("Cowboys",5);

        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c2);
        Thread t3 = new Thread(c3);

        t1.start();
        t2.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            System.out.println("Blah!");
        }
        t3.run();
    }
}
