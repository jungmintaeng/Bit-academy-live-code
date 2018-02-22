package chapter03;

public class SongApp {
	public static void main(String[] args) {
		Song song = new Song();
		song.setArtist("아이유");
		song.setTitle("좋은날");
		song.setAlbum("Real");
		song.setYear(2010);
		song.setTrack(3);
		song.setComposer("이민수");
		song.show();
		
		Song oldSong = new Song("오래된 노래", "스탠딩에그", "미입력", "미입력", 2014, 5);
		oldSong.show();
		
		Song hello = new Song("Hello", "Adele");
		hello.show();
	}
}
