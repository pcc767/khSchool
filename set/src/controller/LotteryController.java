package controller;

import java.util.*;

import model.vo.Lottery;



public class LotteryController {
	private HashSet<Lottery> lottery = new HashSet<>(); // 추첨대상 담아
	private HashSet<Lottery> win = new HashSet<>(); // 당첨대상 담아

	
	public LotteryController() {
		lottery.add(new Lottery("홍길동", "010-1234-5678"));
		lottery.add(new Lottery("최길동", "010-4321-5678"));
		lottery.add(new Lottery("박길동", "010-1234-5678"));
		lottery.add(new Lottery("김길동", "010-1234-5678"));
		lottery.add(new Lottery("유길동", "010-1234-5678"));
		lottery.add(new Lottery("정길동", "010-1234-5678"));
	}
	
	public void printAll() {
		for(Lottery lotto : lottery)
			System.out.println(lotto);
	}
	
	public boolean insertObject(Lottery l) {
		return lottery.add(l);
	}

	public boolean deleteObject(Lottery l) {
		boolean reulst = lottery.remove(l);
		
		if (reulst == true && !win.isEmpty()) {
			win.remove(l);
		}
		return reulst;
	}

	public HashSet<Lottery> winObject() {
		if (lottery.size() < 4) {
			return null;
		}

		ArrayList<Lottery> list = new ArrayList<Lottery>(lottery);
		Random r = new Random();

		while (true) {
			if (win.size() >= 4) {
				break;
			}
			win.add(list.get(r.nextInt(list.size())));
		}
		return win;
	}

	public TreeSet<Lottery> sortedWinObject() {
		TreeSet<Lottery> set = new TreeSet<Lottery>(new Comparator<Lottery>() {
			@Override
			public int compare(Lottery o1, Lottery o2) {
				int result = o1.getName().compareTo(o2.getName());
				if (result == 0) {
					result = o1.getPhone().compareTo(o2.getPhone());
				}
				return result;
			}
		});
		winObject();
		set.addAll(win);
		return set;
	}

	public boolean searchWinner(Lottery l) {
		return win.contains(l);
	}



}
