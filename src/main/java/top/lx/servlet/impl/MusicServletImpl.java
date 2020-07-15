package top.lx.servlet.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.lx.dao.MusicDao;
import top.lx.domain.Music;
import top.lx.servlet.MusicServlet;

import java.util.List;

/**
 * user：chen xi
 *
 * @Description TODO
 * @Date： 2020/6/28  下午 5:20
 */
@Service("musicService")
public class MusicServletImpl implements MusicServlet {
   @Autowired
    private MusicDao musicDao;
    @Override
    public List<Music> findMusic() {
        List<Music> music = musicDao.findMusic();
        return music;
    }

    @Override
    public void savesql(Music music) {
        musicDao.savesql(music);
    }
}
