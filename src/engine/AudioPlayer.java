package engine;

import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

public class AudioPlayer {
	
	
	
	public static Map<String, Sound> soundMap = new HashMap<String, Sound>();
	public static Map<String, Music> musicMap = new HashMap<String, Music>();
	
	//public static VOLUME enumVolume = VOLUME.High;
	private static String currentMusic;
	

	public static void load() {
		
		try {
			
			musicMap.put("background_music", new Music("res/background_music.ogg"));
			
			soundMap.put("click_menu", new Sound("res/click_menu_sound.ogg"));
			soundMap.put("repear_castle", new Sound("res/repear_castle_sound.ogg"));
			soundMap.put("warrior_slash", new Sound("res/warrior_slash_sound.ogg"));
			soundMap.put("warrior_deploy", new Sound("res/warrior_deploy_sound.ogg"));
			soundMap.put("send_worker", new Sound("res/send_worker_sound.ogg"));
			soundMap.put("create_worker", new Sound("res/create_worker_sound.ogg"));
			
			
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	public static void playMusic(String mapKey) {
		
		if(mapKey != currentMusic) {
			
		
			getMusic(mapKey).loop();
		
			/*
			if(enumVolume == VOLUME.High) {
				getMusic(mapKey).setVolume(0.18f);
			}else if(enumVolume == VOLUME.Low) {
				getMusic(mapKey).setVolume(0.05f);
			}else if(enumVolume == VOLUME.Mute){
				getMusic(mapKey).setVolume(0);
			}
			*/
		
			currentMusic = mapKey;
		
		}
		
	}
	
	public static void changeVolume() {
		/*
		if(enumVolume == VOLUME.High) {
			enumVolume = VOLUME.Low;
			getMusic(currentMusic).setVolume(0.05f);
			FileStore.update(13,'1');
			System.out.println("The volume is LOW");
		}
		else if(enumVolume == VOLUME.Low) {
			enumVolume = VOLUME.Mute;
			getMusic(currentMusic).setVolume(0);
			FileStore.update(13,'0');
			System.out.println("The volume is MUTED");
		}
		else if(enumVolume == VOLUME.Mute){
			enumVolume = VOLUME.High;
			getMusic(currentMusic).setVolume(0.1f);
			FileStore.update(13,'2');
			System.out.println("The volume is HIGH");
		}
		*/
	}
	
	public static Music getMusic(String key) {
		return musicMap.get(key);
	}
	
	public static Sound getSound(String key) {
		return soundMap.get(key);
	}
	
}