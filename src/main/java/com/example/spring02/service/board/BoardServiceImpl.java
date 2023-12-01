
package com.example.spring02.service.board;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.spring02.model.board.dao.BoardDAO;
import com.example.spring02.model.board.dto.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	BoardDAO boardDao;

	// 掲示物一覧
	@Override
	public List<BoardVO> listAll() throws Exception {
		return boardDao.listAll();
	}

	// 掲示物作成
	@Override
	public void create(BoardVO vo) throws Exception {
		// String Type(方)の objectを呼び出す
		String title = vo.getTitle();
		String content = vo.getContent();
		String writer = vo.getWriter();
		// 記号をhtmlタグに変換
		title = title.replace("<", "&lt;");
		title = title.replace(">", "&gt;");
		title = title.replace(" ", "&nbsp;");
		title = title.replace("\n", "<br>");
		content = content.replace("<", "&lt;");
		content = content.replace(">", "&gt;");
		content = content.replace(" ", "&nbsp;");
		content = content.replace("\n", "<br>");
		writer = writer.replace("<", "&lt;");
		writer = writer.replace(">", "&gt;");
		writer = writer.replace(" ", "&nbsp;");
		writer = writer.replace("\n", "<br>");
		vo.setTitle(title);
		vo.setContent(content);
		vo.setWriter(writer);
		boardDao.create(vo);
	}

	// 掲示物照会数増加
	@Override
	public void increaseViewcnt(int bno) throws Exception {
		boardDao.increaseViewcnt(bno);
	}

	// 掲示物詳細見る
	@Override
	public BoardVO read(int bno) throws Exception {
		return boardDao.read(bno);
	}

	// 掲示物修正
	@Override
	public void update(BoardVO vo) throws Exception {
		boardDao.update(vo);
	}

	// 掲示物削除
	@Override
	public void delete(int bno) throws Exception {
		boardDao.delete(bno);
	}

	// 掲示物詳細内容照会
	@Override
	public ModelAndView existData(int bno, RedirectAttributes redirectModel) throws Exception {
		int count = boardDao.existData(bno);
		if (count == 0) {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("redirect:list.do");
//		    mav.addObject("exist", "データがありません。");
			redirectModel.addFlashAttribute("exist", "データがありません。");
			return mav;
		}
		boardDao.increaseViewcnt(bno);
		// データタイプ(ModelAndView) object(mav)生成。
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/view");
		mav.addObject("dto", boardDao.read(bno));
		return mav;
	}

	// 掲示物修正画面移動
	@Override
	public ModelAndView existData2(int bno, RedirectAttributes redirectModel) throws Exception {
		int count = boardDao.existData(bno);
//		if (count == 0) {
//			ModelAndView mav = new ModelAndView();
//			mav.setViewName("redirect:list.do");
////		    mav.addObject("exist", "データがありません。");
//			redirectModel.addFlashAttribute("exist", "データがありません。");
//			return mav;
//		}
		// データタイプ(ModelAndView) object(mav)生成。
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/change");
		mav.addObject("dto", boardDao.read(bno));
		return mav;
	}

//	@Override
//	public ModelAndView existData3(int bno, RedirectAttributes redirectModel) throws Exception {
//		int count = boardDao.existData(bno);
//		if (count == 0) {
//			ModelAndView mav = new ModelAndView();
//			mav.setViewName("board/list");
//			redirectModel.addFlashAttribute("exist", "データがありません。");
//			return mav;
//		}
//		return null;
//	}
}
