package com.kh.pratice.set.view;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

import com.kh.pratice.set.controller.LotteryController;
import com.kh.pratice.set.model.vo.Lottery;

public class LotteryMenu {
	
	
	LotteryController lc = new LotteryController();
    public static Scanner sc = new Scanner(System.in);

    public void mainMenu(){
        while (true) {
            System.out.println("========== KH ��÷ ���α׷� ==========");
            System.out.println("***** ���� �޴� *****");
            System.out.println("1. ��÷ ��� �߰�");
            System.out.println("2. ��÷ ��� ����");
            System.out.println("3. ��÷ ��� Ȯ��");
            System.out.println("4. ���ĵ� ��÷ ��� Ȯ��");
            System.out.println("5. ��÷ ��� �˻�");
            System.out.println("9. ����");
            System.out.print("�޴� ��ȣ ���� : ");
            int inputNum = Integer.parseInt(sc.nextLine());

            switch (inputNum) {
                case 1:
                    insertObject();
                    break;
                case 2:
                    deleteObject();
                    break;
                case 3:
                    winObject();
                    break;
                case 4:
                    sortedWinObject();
                    break;
                case 5:
                    searchWinner();
                    break;
                case 9:
                    System.out.println("���α׷� ����");
                    return;
                default:
                    System.out.println("�� �� �Է��ϼ̽��ϴ�. �ٽ� �Է��� �ּ���.");
            }
        }
    }

    public void insertObject() {
        System.out.println("�߰��� ��÷ ��� �� : ");
        int addNum = Integer.parseInt(sc.nextLine());
        for(int i=0; i<addNum; i++){
            System.out.println("�̸� : ");
            String name = sc.nextLine();
            System.out.println("�ڵ��� ��ȣ('-'����) : ");
            String phone = sc.nextLine();

            boolean addUser = lc.insertObject(new Lottery(name, phone));
            if(!addUser){
                System.out.println("�ߺ��� ����Դϴ�. �ٽ� �Է��ϼ���.");
            }
        }
        System.out.println(addNum+"�� �߰� �Ϸ� �Ǿ����ϴ�.");
    }

    public void deleteObject() {
        System.out.println("������ ����� �̸��� �ڵ��� ��ȣ�� �Է��ϼ���.");
        System.out.println("�̸� : ");
        String name = sc.nextLine();
        System.out.println("�ڵ��� ��ȣ('-'����) : ");
        String phone = sc.nextLine();

        boolean delUser = lc.deleteObject(new Lottery(name, phone));
        if(delUser){
            System.out.println("���� �Ϸ� �Ǿ����ϴ�.");
        }
        if(!delUser){
            System.out.println("�������� �ʴ� ����Դϴ�.");
        }
    }

    public void winObject() {
        HashSet<Lottery> win = lc.winObject();
        Iterator<Lottery> iterator = win.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

    public void sortedWinObject() {
        TreeSet<Lottery> sort = lc.sortedWinObject();
        Iterator<Lottery> iterator = sort.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public void searchWinner() {
        System.out.println("�˻��� ����� �̸��� �ڵ��� ��ȣ�� �Է��ϼ���");
        System.out.println("�̸� : ");
        String name = sc.nextLine();
        System.out.println("�ڵ��� ��ȣ('-'����) : ");
        String phone = sc.nextLine();

        boolean winner = lc.searchWinner(new Lottery(name, phone));
        if (!winner){
            System.out.println("��Ÿ������ ��÷ ��Ͽ� �������� �ʽ��ϴ�.");
        } else {
            System.out.println("�����մϴ�. ��÷ ��Ͽ� �����մϴ�.");
        }

    }

}
