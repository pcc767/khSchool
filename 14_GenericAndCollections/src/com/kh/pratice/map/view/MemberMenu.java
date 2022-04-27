package com.kh.pratice.map.view;

import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.TreeMap;

import com.kh.pratice.map.controller.MemberController;
import com.kh.pratice.map.model.vo.Member;

public class MemberMenu {
	
	MemberController mc = new MemberController();
    public static Scanner sc = new Scanner(System.in);

    public void mainMenu(){
        while (true) {
            System.out.println("========== KH ���̵� ==========");
            System.out.println("===== ���� �޴� =====");
            System.out.println("1. ȸ������.");
            System.out.println("2. �α���.");
            System.out.println("3. ���� �̸� ȸ�� ã��.");
            System.out.println("9. ����.");
            System.out.print("�޴� ��ȣ ���� : ");
            int inputNum = Integer.parseInt(sc.nextLine());

            switch (inputNum) {
                case 1:
                    joinMembership();
                    break;
                case 2:
                    login();
                    memberMenu();
                    break;
                case 3:
                    sameName();
                    break;
                case 9:
                    System.out.println("���� �մϴ�.");
                    return;
                default:
                    System.out.println("�� �� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
            }
        }
    }

    private void memberMenu() {
        System.out.println("===== ȸ�� �޴� =====");
        System.out.println("1. ��й�ȣ �ٲٱ�.");
        System.out.println("2. �̸� �ٲٱ�.");
        System.out.println("3. �α׾ƿ�.");
        System.out.print("�޴� ��ȣ ���� : ");
        int inputNum = Integer.parseInt(sc.nextLine());

        switch (inputNum) {
            case 1 :
                changePassword();
                break;
            case 2 :
                changeName();
                break;
            case 3 :
                System.out.println("�α׾ƿ� �Ǿ����ϴ�.");
                return;
            default :
                System.out.println("�� �� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
        }


    }

    private void joinMembership() {
        boolean isSuccess = false;
        while (true) {
            System.out.print("1. ���̵� : ");
            String id = sc.nextLine();
            System.out.print("2. ��й�ȣ : ");
            String password = sc.nextLine();
            System.out.print("3. �̸� : ");
            String name = sc.nextLine();

            isSuccess = mc.joinMembership(id, new Member(password, name));

            if (!isSuccess) {
                System.out.println("�ߺ��� ���̵��Դϴ�. �ٽ� �Է����ּ���.");
                continue;
            }else {
                System.out.println("���������� ȸ������ �Ϸ��ϼ̽��ϴ�.");
                return;
            }
        }
    }

    private void login() {
        while (true) {
            System.out.print("1. ���̵� : ");
            String id = sc.nextLine();
            System.out.print("2. ��й�ȣ : ");
            String password = sc.nextLine();

            String user = mc.login(id, password);

            if (user.equals("")) {
                System.out.println("Ʋ�� ���̵� �Ǵ� ��й�ȣ�Դϴ�. �ٽ� �Է����ּ���.");
                continue;
            }else {
                System.out.println(user+"�� ȯ���մϴ�.");
                return;
            }
        }
    }

    private void sameName() {
        System.out.print("�˻��� �̸� : ");
        String name = sc.nextLine();
        Map<String, String> treeMap = new TreeMap<String, String>();
        treeMap = mc.sameName(name);
        for(Map.Entry<String, String> entry : treeMap.entrySet()) {
            System.out.println("[�̸�] : "+entry.getKey()+", [���̵�] : "+entry.getValue());
        }

    }

    private void changeName() {
        while (true) {
            System.out.print("���̵� : ");
            String id = sc.nextLine();
            System.out.print("��й�ȣ : ");
            String password = sc.nextLine();

            String changeName = mc.login(id, password);
            if (Objects.equals(changeName, "")) {
                System.out.println("�̸� ���濡 �����Ͽ����ϴ�. �ٽ� �Է��� �ּ���.");
                continue;
            }
            System.out.println("���� �̸� : "+changeName);

            System.out.print("������ �̸� : ");
            String newName = sc.nextLine();
            mc.changeName(id, newName);
            System.out.println("�̸� ���濡 �����Ͽ����ϴ�.");
            return;
        }
    }

    private void changePassword() {
        System.out.print("���̵� : ");
        String id = sc.nextLine();
        System.out.print("��й�ȣ : ");
        String oldPw = sc.nextLine();
        System.out.print("������ ��й�ȣ : ");
        String newPw = sc.nextLine();

        boolean changePw = mc.changePassword(id,oldPw,newPw);

        if(!changePw){
            System.out.println("��й�ȣ ���濡 �����߽��ϴ�. �ٽ� �Է��� �ּ���.");
        }else{
            System.out.println("��й�ȣ ���濡 �����Ͽ����ϴ�.");
        }
    }

}
