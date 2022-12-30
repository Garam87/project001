package edu.kh.semi.model.service;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.kh.semi.model.vo.Manager;

public class ManagerService {

	
	private Scanner sc = new Scanner(System.in);
	private List<Manager> manager = new ArrayList<Manager>();
	private List<Manager> loginMember = null;
	
	public void displayMenu() {
		int inputNum = 8;
		do {
			System.out.println("==== 회원 관리 프로그램 ====");
			System.out.println("1. 회원가입 ");
			System.out.println("2. 로그인 ");
			System.out.println("3. 회원정보 ");
			System.out.println("4. 회원수정 ");
			System.out.println("5. 전체회원보기 ");
			System.out.println("6. 회원검색 ");
			System.out.println("7. 회원탈퇴 ");
			System.out.println("8. 회원 수칙 ");
			System.out.println("9. 프로그램종료 ");
			
			try {
				System.out.print("메뉴입력 >>> ");
				inputNum = sc.nextInt();
				sc.nextLine();
				
				switch(inputNum) {
				case 1 : System.out.println(SignUp()); break;
				case 2 : login(); break;
				case 3 : information(); break;
				case 4 : updateManager(); break;
				case 5 : selectAll(); break;
				case 6 : search(); break;
				case 7 : remove(); break;
				case 8 : text(); break;
				case 9 : System.out.println("프로그램 종료"); break;
				default : System.out.println("1 ~ 9까지의 번호만 입력해주세요");
				}
			} catch(Exception e) {
				System.out.println("올바른 입력을 해주세요");
				sc.nextLine();
				inputNum = -1;
			}
		} while(inputNum != 9);
	}
				
	public String SignUp() throws Exception {
		System.out.println("\n===== 회원가입 =====");
		System.out.print("아이디 : ");
		String id = sc.next();
		
		for (Manager mem : manager) {
			if(id.equals(mem.getId())) {
				System.out.println("사용할수 없는 아이디 입니다.");
				return SignUp();
			}
		}
		
		System.out.print("비밀번호 : ");
		String pw = sc.next();
		
		System.out.print("비밀번호 확인 : ");
		String pw2 = sc.next();
		
		System.out.print("이름 : ");
		String name = sc.next();
		
		System.out.print("나이 : ");
		int age = sc.nextInt();
		sc.nextLine();
		
		System.out.print("주소 : ");
		String address = sc.nextLine();
		
		
		if(pw.equals(pw2)) {
			manager.add(new Manager(id, pw, name, age, address));
			return "회원가입이 완료되었습니다.\n"; 
		} else {
			return "비밀번호를 확인해주세요\n";
		}
				
		
	}

	public void login() throws Exception {
		System.out.println("\n===== 로그인 화면 =====");
		
		if(manager.isEmpty()) {
			System.out.println("\n회원가입 먼저 진행해 주세요\n");
		} else {
			System.out.print("아이디 입력 : ");
			String id = sc.next();
			System.out.print("비밀번호 입력 : ");
			String pw = sc.next();
			for (Manager mg : manager) {
				if(id.equals(mg.getId()) && pw.equals(mg.getPw())) {
					loginMember = manager;
					System.out.println( mg.getName() + "님 환영합니다." );
				} else {
					System.out.println( "아이디 혹은 비밀번호를 다시 확인하여 주십시오" );
				}
			}
		}
		
	}
			
	public void information() throws Exception {
		System.out.println("\n===== 회원정보 ======\n");
		if(loginMember == null) {
			System.out.println("로그인을 먼저 해주세요\n");
		} else {
			for (Manager login : loginMember) {
				System.out.print("아이디 --> " + login.getId());
				System.out.println();
				System.out.print("이름 --> " + login.getName());
				System.out.println();
				System.out.print("나이 --> " + login.getAge());
				System.out.println();
				System.out.print("주소 --> " + login.getAddress());
				System.out.println();
			}
		}
				 
	}

	public void updateManager() throws Exception {
		System.out.println("\n===== 회원정보 수정 =====\n");
		if(loginMember == null) {
			System.out.println("로그인을 먼저 해주세요.\n");
		} else {
			System.out.print("수정할 이름 입력: ");
			String inputName = sc.next();
			
			System.out.print("수정할 나이 입력: ");
			int inputAge = sc.nextInt();
			sc.nextLine(); // 인트다음에 오는 문자열 받으실시 넥스트라인 넣어주기!!
			
			System.out.print("수정할 주소 입력: ");
			String inputAddress = sc.next();
			
			boolean flag = true;
			
			for (Manager login : loginMember) {
				System.out.print("현재 비밀번호 입력: ");
				String inputPw = sc.next();
				
				if(inputPw.equals(login.getPw())) {
					login.setName(inputName);
					login.setAge(inputAge);
					login.setAddress(inputAddress);
					System.out.println("회원님의 정보가 변경되었습니다.");
					flag = false;
				}
				if(flag) {
					System.out.println("잘못 입력하셨습니다. 비밀번호를 다시 확인해주세요");
					
				}
			}
		}
	}

	public void selectAll() throws Exception {
		System.out.println("\n===== 회원전체 정보 ======\n");
		if(manager.isEmpty()) {
			System.out.println("가입한 회원이 없습니다\n");
		} else {
			for (Manager all : manager) {
				System.out.println(all);
			}
		}
	}

	public void search() throws Exception {
		System.out.println("\n===== 회원 검색 =====\n");
		
		boolean flag = true;
		
		if(manager.isEmpty()) {
			System.out.println("가입한 회원이 없습니다.\n");
		} else {
			System.out.print("찾으실 회원 이름 입력 : ");
			String name = sc.next();
			for (Manager member : manager) {
				if(name.equals(member.getName())) {
					System.out.println(member);
					flag = false;
				} 
			}
			if(flag) {	
				System.out.println("\n찾으시는 회원이 없습니다.\n");
			}
		}
	}

	public void remove() throws Exception {
		System.out.println("\n===== 회원 탈퇴 =====\n");
		if(loginMember == null) {
			System.out.println("로그인이 안되어 있습니다\n");
		} else {
			System.out.print("정말 탈퇴 하시겠습니까? (y/n) : ");
			char remove = sc.next().toUpperCase().charAt(0);
			if(remove == 'Y') {
				for (Manager mem : loginMember) {
					loginMember.remove(mem);
					System.out.println("회원 탈퇴 처리 되엇습니다.");
					loginMember = null;
					displayMenu();
				}
			} else if(remove == 'N') {
				System.out.println("취소");
			} else {
				System.out.println("잘못입력 하셨습니다.");
			}
		}
		
	}

	public void text() {
		
		FileReader rule = null;
		
		try {
			rule = new FileReader("text01.txt");
			
			while(true) {
				int data = rule.read();
				
				if(data == -1) {
					break;
				}
				
				System.out.print((char)data);
				
			}
			System.out.println();
		} catch(IOException e) {
			System.out.println("파일이 없습니다.");
		} finally {
			try {
				rule.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
			
		
				
		
			
			
		
			
			
					
			
			
			
		
		
		

					
		
			
			
		
		
	
	
	

