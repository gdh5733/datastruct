package 数据结构.queue;
import java.util.Scanner;
/**
 * 数组实现
 */

public class ArrayQueueDemo {

    public static void main(String[] args) {
       //测试一把
        //创建一个队列
        ArrayQueue queue = new ArrayQueue(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        //输出一个菜单
        while(loop){
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 推出程序");
            System.out.println("a(add): 添加数据");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");

            key=scanner.next().charAt(0);//从键盘获取一个字符

            switch (key){

                case 's':
                    queue.showQueue();
                    break;

                case 'a':
                    System.out.println("请输入一个整数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;

                case 'g'://取数据
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }

                case 'h'://查看队列头
                    try {
                        int res = queue.headQueuepeek();
                        System.out.printf("输出队列头的数据是：%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }

                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
        }
        }
    }
}

class ArrayQueue{

    private int maxSize;//表示数组的最大容量
    private int rear;//队列尾部
    private int front;//队列头部
    private int[] arr;//该数据用于存放数据，模拟队列


    //创建队列的构造器
    public ArrayQueue(int arrMaxSize){
        maxSize  = arrMaxSize;
        arr = new int[maxSize];
        front = -1;//指向队列头部，分析front是指向队列头的前一个位置
        rear = -1;//指向队列尾，指向队列尾的数据(就是最后一个数据)
    }

    //判断队列是否满
    public boolean isFull(){
        return rear == maxSize-1;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }


    //添加数据到队列
    public void addQueue(int n){
        if (isFull()){
            throw new RuntimeException("队列满");
        }
        rear++;
        arr[rear] = n;
    }


    //取数据
    public int getQueue(){
        //判断队列是否为空
        if (isEmpty()){
            System.out.println("队列空的，没有数据～～");
        }
        front++;//front后移
        return arr[front];
    }

    //显示队列的所有数据
    public void showQueue(){
        //遍历
        if (isEmpty()){
            System.out.println("队列空的没有数据～～");
            return;
        }
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    //显示队列的头数据，注意不是取出数据
    public int headQueuepeek(){

        //判断
        if (isEmpty()){
            System.out.println("队列为空");
        }
        return arr[front+1];
    }



}
