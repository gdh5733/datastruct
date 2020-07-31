package 数据结构.linkedlist;

/**
 * 简单链表实现英雄的排序
 */
public class SinglinkedListDemo {

    public static void main(String[] args) {

    }
}


//定义HeroNode,每个HeroNode 对象就是一个节点
class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;//指向下一节点

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", next=" + next +
                '}';
    }
}


//定义SinglinkedList来管理我们的英雄
class SinglinkedList {

    //先初始化一个头节点,头节点不要动,不存放具体的数据
    private HeroNode head = new HeroNode(0, "", "");
    //添加节点到单项链表
    //思路 当不考虑编号顺序时
    //1.找到当前节点的最后节点
    //2.将最后这个节点的next指向 新的节点

    public void add(HeroNode heroNode) {
        //因为head节点不能动,因此我们需要一个辅助遍历temp
        HeroNode temp = head;

        while (true) {
            //找到链表的最后
            if (temp.next == null) {
                break;
            }
            //如果没有找到,就将temp后移
            temp = temp.next;
        }

        //当退出循环的时候,temp就指向了链表的最后
        //将最后节点的next指向新的节点
        temp.next = heroNode;

    }


    //遍历链表
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点不能动,因此我们需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while (true) {
            //判断是否到链表最后
            if (temp == null) {
                break;
            }
            //输出节点信息
            System.out.println(temp);

            //将temp后移 一定要小心
            temp = temp.next;
        }
    }

}
