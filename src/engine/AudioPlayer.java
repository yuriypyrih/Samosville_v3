package engine;

import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

public class AudioPlayer {
	
	
	
	public static Map<String, Sound> soundMap = new HashMap<String, Sound>();
	public static Map<String, Music> musicMap = new HashMap<String, Music>();
	
	
	
	
	public static VOLUME Volume_Music = VOLUME.High;
	public static VOLUME Volume_Sound = VOLUME.High;
	
	public static float sound_solume_multiplier = 1f;
	
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
			soundMap.put("pop", new Sound("res/pop_sound.ogg"));
			soundMap.put("victory", new Sound("res/victory_sound.ogg"));
			soundMap.put("defeat", new Sound("res/defeat_sound.ogg"));
			
			
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	public static void playMusic(String mapKey) {
		
		if(mapKey != currentMusic) {
			
		
			getMusic(mapKey).loop();
		
			
			if(Volume_Music == VOLUME.High) {
				getMusic(mapKey).setVolume(0.18f);
			}else if(Volume_Music == VOLUME.Low) {
				getMusic(mapKey).setVolume(0.05f);
			}else if(Volume_Music == VOLUME.Mute){
				getMusic(mapKey).setVolume(0);
			}
			
		
			currentMusic = mapKey;
		
		}
		
	}
	
	public static void changeMusicVolume() {
		
		if(Volume_Music == VOLUME.High) {
			Volume_Music = VOLUME.Low;
			getMusic(currentMusic).setVolume(0.05f);
			//FileStore.update(13,'1');
			System.out.println("The music volume is LOW");
		}
		else if(Volume_Music == VOLUME.Low) {
			Volume_Music = VOLUME.Mute;
			getMusic(currentMusic).setVolume(0);
			//FileStore.update(13,'0');
			System.out.println("The music volume is MUTED");
		}
		else if(Volume_Music == VOLUME.Mute){
			Volume_Music = VOLUME.High;
			getMusic(currentMusic).setVolume(0.1f);
			//FileStore.update(13,'2');
			System.out.println("The music volume is HIGH");
		}
		
	}
	
public static void changeSoundVolume() {
		
		if(Volume_Sound == VOLUME.High) {
			Volume_Sound = VOLUME.Low;
			sound_solume_multiplier = 0.5f;
			//FileStore.update(13,'1');
			System.out.println("The sound volume is LOW");
		}
		else if(Volume_Sound == VOLUME.Low) {
			Volume_Sound = VOLUME.Mute;
			sound_solume_multiplier = 0f;
			//FileStore.update(13,'0');
			System.out.println("The sound volume is MUTED");
		}
		else if(Volume_Sound == VOLUME.Mute){
			Volume_Sound = VOLUME.High;
			sound_solume_multiplier = 1f;
			//FileStore.update(13,'2');
			System.out.println("The sound volume is HIGH");
		}
		
	}

	public static String MusicVolumetoString() {
		if(Volume_Music == VOLUME.High) {
			return "High";
		}
		else if ( Volume_Music == VOLUME.Low) {
			return "Low";
		}
		else if( Volume_Music == VOLUME.Mute) {
			return "Mute";
		}
		else {
			return "Undefined";
		}
	}
	
	public static String SoundVolumetoString() {
		if(Volume_Sound == VOLUME.High) {
			return "High";
		}
		else if ( Volume_Sound == VOLUME.Low) {
			return "Low";
		}
		else if( Volume_Sound == VOLUME.Mute) {
			return "Mute";
		}
		else {
			return "Undefined";
		}
	}
	
	public static Music getMusic(String key) {
		return musicMap.get(key);
	}
	
	public static Sound getSound(String key) {
		return soundMap.get(key);
	}
	
}