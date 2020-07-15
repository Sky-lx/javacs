package top.lx.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import top.lx.domain.Music;
import top.lx.servlet.MusicServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

//将类交spring来管理
@Controller
//一级路径一般用实体类名
@RequestMapping("/music")
public class MusicController {
    @Autowired
    private MusicServlet musicServlet;

//    wwwwww
    @RequestMapping(value = "/findMusic", produces = "text/html;charset=UTF-8")
    @ResponseBody
    protected String FindMusic(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        ObjectMapper mapper = new ObjectMapper();
        List<Music> musics = musicServlet.findMusic();
        String path = request.getSession().getServletContext().getRealPath("file");
        //        获取听歌路径
        for (Music music : musics) {
            String title = music.getTitle();
//            将中文转成字符
            String utftitle = URLEncoder.encode(title, "UTF-8").replace("%", "");
            music.setUrl("http://10.41.250.5/demo/file/" + utftitle + ".mp3");
        }
        String str = mapper.writeValueAsString(musics);
        return str;
    }

    //    访问音乐url
    @RequestMapping(value = "/csmusic", produces = "text/html;charset=UTF-8")
    @ResponseBody
    protected void csMusic(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    @RequestMapping("/fileupload")
    @ResponseBody
    public void fileupload(HttpServletRequest request, HttpServletResponse response, MultipartFile upload/*这个参数名要与jsp中的文件上传控件一致*/) throws UnsupportedEncodingException {
//       获得发起请求的url
        String fromURL = request.getHeader("Referer");
        //获取上传的位置
        String path = request.getSession().getServletContext().getRealPath("/file/");
        System.out.println(path);
//    判断路径是否存在
        File file = new File(path);
        if (!file.exists()) {
//            创建文件夹
            file.mkdirs();
            System.out.println("文件夹创建成功");
        }
        List<Music> musics = musicServlet.findMusic();
        String url = musics.get(musics.size() - 1).getUrl();
       try {
            upload.transferTo(new File(path, url));
           response.setStatus(302);//设置状态码
           response.sendRedirect(fromURL);
       } catch (IOException e) {
            new Exception("文件上传错误");
        }
//        File file1 = new File("");
    }

    @RequestMapping("/savesql")
    @ResponseBody
    public void savesql(Music music, HttpServletResponse response) throws IOException {

        System.out.println(music.toString());
        musicServlet.savesql(music);
        response.getWriter().print("文件己上传");
    }

   }