package top.lx.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import top.lx.domain.Music;
import top.lx.domain.User;

import java.util.List;

/**
 * user：chen xi
 *
 * @Description TODO
 * @Date： 2020/6/28  下午 5:17
 */
public interface MusicDao {
    //搜索时显示所有歌
    @Select(" select * from music")
    List<Music> findMusic();
//    文件上传
    @Insert("insert into music(title,singer,url) VALUES (#{title},#{singer},#{url})")
    void savesql(Music music);
}
