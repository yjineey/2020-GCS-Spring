package com.example.spring02.service.board;
 
import java.util.List;
 

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.spring02.model.board.dto.BoardVO;
 
public interface BoardService {
	
    // 掲示物一覧
    public List<BoardVO> listAll() throws Exception;
    // 掲示物作成
    public void create(BoardVO vo) throws Exception;
    // 掲示物照会数追加
    public void increaseViewcnt(int bno) throws Exception;
    // 掲示物詳細見る
    public BoardVO read(int bno) throws Exception;
    // 掲示物修正
    public void update(BoardVO vo) throws Exception;
    // 掲示物の削除
    public void delete(int bno) throws Exception;
    // 掲示物詳細内容照会
    public ModelAndView existData(int bno, RedirectAttributes redirectModel) throws Exception;
    // 掲示物修正画面移動
    public ModelAndView existData2(int bno, RedirectAttributes redirectModel) throws Exception;
//    public ModelAndView existData3(int bno, RedirectAttributes redirectModel) throws Exception;

}
 
