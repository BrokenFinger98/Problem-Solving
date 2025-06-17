import java.lang.*;
import java.util.*;

class Solution {
	static class Song implements Comparable<Song>{
		int time, index;

		public Song(int time, int index) {
			this.time = time;
			this.index = index;
		}

		@Override
		public int compareTo(Song o) {
			if (this.time == o.time) {
				return this.index - o.index;
			}
			return o.time - this.time;
		}
	}

	static class Genre implements Comparable<Genre>{
		String genre;
		int time;
		public Genre(String genre, int time) {
			this.genre = genre;
			this.time = time;
		}

		@Override
		public int compareTo(Genre o) {
			return o.time - this.time;
		}
	}

	static Map<String, PriorityQueue<Song>> map1 = new HashMap<>();
	static Map<String, Integer> map2 = new HashMap<>();
	static PriorityQueue<Genre> pq = new PriorityQueue<>();
	public int[] solution(String[] genres, int[] plays) {
		List<Integer> list = new ArrayList<>();

		for(int i = 0; i < genres.length; i++){
			if(map2.containsKey(genres[i]) && map1.containsKey(genres[i])){
				map2.put(genres[i], map2.get(genres[i]) + plays[i]);
				Song song = new Song(plays[i], i);
				PriorityQueue<Song> songs = map1.get(genres[i]);
				songs.offer(song);
			}else{
				PriorityQueue<Song> songs = new PriorityQueue<>();
				songs.offer(new Song(plays[i], i));
				map1.put(genres[i], songs);
				map2.put(genres[i], plays[i]);
			}
		}

		for (Map.Entry<String, Integer> stringIntegerEntry : map2.entrySet()) {
			pq.offer(new Genre(stringIntegerEntry.getKey(), stringIntegerEntry.getValue()));
		}

		while(!pq.isEmpty()){
			Genre genre = pq.poll();
			PriorityQueue<Song> songs = map1.get(genre.genre);
			int i = 0;
			while(!songs.isEmpty() && i++ <= 1){
				list.add(songs.poll().index);
			}
		}
		return list.stream().mapToInt(i -> i).toArray();
	}
}