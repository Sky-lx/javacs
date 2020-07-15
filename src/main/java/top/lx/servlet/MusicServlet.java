package top.lx.servlet;

import top.lx.domain.Music;

import java.util.List;

/**
 * user：chen xi
 *
 * @Description TODO
 * @Date： 2020/6/28  下午 5:18
 */
public interface MusicServlet {
    //搜索时显示所有歌
    List<Music> findMusic();

    void savesql(Music music);


}
