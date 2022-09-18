package com.example.Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class N_Meetings {

	class meeting {
		int start;
		int end;
		int pos;

		meeting(int start, int end, int pos) {
			this.start = start;
			this.end = end;
			this.pos = pos;
		}
	}

	class meetingComparator implements Comparator<meeting> {
		@Override
		public int compare(meeting o1, meeting o2) {
			if (o1.end < o2.end)
				return -1;
			else if (o1.end > o2.end)
				return 1;
			else if (o1.pos < o2.pos)
				return -1;
			return 1;
		}
	}

	public static void main(String args[]) {
		int start[] = { 1, 3, 0, 5, 8, 5 };
		int end[] = { 2, 4, 6, 7, 9, 9 };
		List<Integer> ans = maxMeetings(start, end, start.length);
		//System.out.println(ans);
	}

	private static List<Integer> maxMeetings(int start[], int end[], int n) {

		ArrayList<meeting> meet = new ArrayList<>();
		N_Meetings obj=new N_Meetings();
		for (int i = 0; i < start.length; i++)
			meet.add(obj.new meeting(start[i], end[i], i + 1));

		meetingComparator mc = obj.new meetingComparator();
		Collections.sort(meet, mc);
		ArrayList<Integer> answer = new ArrayList<>();
		answer.add(meet.get(0).pos);
		int limit = meet.get(0).end;

		for (int i = 1; i < start.length; i++) {
			if (meet.get(i).start > limit) {
				limit = meet.get(i).end;
				answer.add(meet.get(i).pos);
			}
		}

		for (int i = 0; i < answer.size(); i++) {
			System.out.print(answer.get(i) + " ");
		}
		
		return answer;
	}

}
