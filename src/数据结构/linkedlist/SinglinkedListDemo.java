package 数据结构.linkedlist;

/**
 * 简单链表实现英雄的排序
 */
public class SinglinkedListDemo {

    public static void main(String[] args) {
        //进行测试
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        //创建要给链表
        SinglinkedList singlinkedList = new SinglinkedList();

        //添加英雄
//        singlinkedList.add(hero1);
//        singlinkedList.add(hero2);
//        singlinkedList.add(hero3);
//        singlinkedList.add(hero4);


        singlinkedList.addByOrder(hero1);
        singlinkedList.addByOrder(hero2);
        singlinkedList.addByOrder(hero3);
        singlinkedList.addByOrder(hero4);

        singlinkedList.addByOrder(hero4);



        //显示一把
        singlinkedList.list();
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
                ", nickName='" + nickName;
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


    //插入的时候根据排名，将英雄插入到指定的位置
    //如果有这个排名，则提示添加失败，并给出提示
    public void addByOrder(HeroNode heroNode) {
        //因为头节点不能动，因此我们仍然通过一个辅助指针变量来帮助找到添加的位置
        //因为单链表，因为我们找到的temp是位于添加位置的前一个节点，否则插入不了
        HeroNode temp = head;

        boolean flag = false;//flag标志添加的编号是否存在，默认为false
        while (true) {
            if (temp.next == null) {//说明temp已经在链表的最后
                break;
            }
            if (temp.next.no > heroNode.no) {//位置找到，就在temp的位置插入
                break;
            } else if (temp.next.no == heroNode.no) {//说明编号已经存在
                flag = true;
                break;
            }
            temp = temp.next;//后移
        }
        //判断lag的值
        if (flag) {
            System.out.println("编号已经存在，不能添加了 -----"+heroNode.no);
        } else {
            //插入到链表中，temp的后面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
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
