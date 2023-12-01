//掲示板プロジェクト
package com.example.spring02.controller.board;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.spring02.model.board.dto.BoardVO;
import com.example.spring02.service.board.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	@Inject
	BoardService boardService;

//	private static Logger logger=LoggerFactory.getLogger(BoardController.class);
			
	// 掲示物一覧
	@RequestMapping("list.do")
	public ModelAndView list() throws Exception {
		// ModelAndView Type(型) mav object生成
		ModelAndView mav = new ModelAndView();
		// boardservice.listallよびだす
		List<BoardVO> list = boardService.listAll();
		// boardフォルダーのlist.jspに設定。
		mav.setViewName("board/list");
		mav.addObject("list", list);
		return mav;
	}

	// 掲示板作成
	@RequestMapping("write.do")
	public String write() {
		// write.jspに移動。
		return "board/write";
	}

	// 掲示物作成処理
	@RequestMapping(value = "insert.do", method = RequestMethod.POST)
	public String insert(@ModelAttribute BoardVO vo, Model model) throws Exception {
		// ArrayList Type(型) message object生成
		List<String> message = new ArrayList<String>();
		// isEmpty = null
		if (StringUtils.isEmpty(vo.getTitle())) {
			message.add("タイトルを入力してください。");
		} else {
			// 文字数チェック
			if (vo.getTitle().length() > 200) {
				message.add("タイトルは200字以下で入力してください。");
			}
		}

		if (StringUtils.isEmpty(vo.getContent())) {
			message.add("内容を入力してください。");
		} else {
			if (vo.getContent().length() > 1000) {
				message.add("内容は1000字以下で入力してください。");
			}
		}

		if (StringUtils.isEmpty(vo.getWriter())) {
			message.add("作成者を入力してください。");
		} else {
			if (vo.getWriter().length() > 50) {
				message.add("作成者は50字以下で入力してください。");
			}
		}

		if (message.size() == 0) {
			boardService.create(vo);
			return "redirect:list.do";
		} else {
			model.addAttribute("msg", message);
			model.addAttribute("title", vo.getTitle());
			model.addAttribute("content", vo.getContent());
			model.addAttribute("writer", vo.getWriter());
			// write.jspに移動。
			return "board/write";
		}
	}

	// 掲示物詳細内容照会
	@RequestMapping(value = "view.do", method = RequestMethod.GET)
	public ModelAndView view(@RequestParam int bno, RedirectAttributes redirectModel) throws Exception {
		ModelAndView mav = boardService.existData(bno,redirectModel);
		return mav;
	}

	// 掲示物修正画面移動
	@RequestMapping(value = "change.do", method = RequestMethod.GET)
	public ModelAndView change(@RequestParam int bno, RedirectAttributes redirectModel) throws Exception {
		ModelAndView mav = boardService.existData2(bno, redirectModel);
		return mav;
	}

	// 修正画面
	@RequestMapping(value = "update.do", method = RequestMethod.POST)
	public String update(@ModelAttribute BoardVO vo, Model model) throws Exception {
//		logger.debug("로그 debug 테스트");
//		logger.info("로그 info 테스트");
		// ArrayList Type(型) message object生成
		List<String> message = new ArrayList<String>();
		// isEmpty = null
		if (StringUtils.isEmpty(vo.getTitle())) {
			message.add("タイトルを入力してください。");
		} else {
			// 文字数チェック
			if (vo.getTitle().length() > 200) {
				message.add("タイトルは200字以下で入力してください。");
			}
		}
		if (StringUtils.isEmpty(vo.getContent())) {
			message.add("内容を入力してください。");
		} else {
			if (vo.getContent().length() > 1000) {
				message.add("内容は1000字以下で入力してください。");
			}
		}
		if (StringUtils.isEmpty(vo.getUpd_id())) {
			message.add("修正者を入力してください。");
		} else {
			if (vo.getUpd_id().length() > 50) {
				message.add("修正者は50字以下で入力してください。");
			}
		}
		if (message.size() == 0) {
			boardService.update(vo);
			model.addAttribute("dto", boardService.read(vo.getBno()));
			return "board/view";
		} else {
			BoardVO readData = boardService.read(vo.getBno());
			vo.setUpd_date(readData.getUpd_date());
			vo.setRegdate(readData.getRegdate());
			model.addAttribute("msg", message);
			model.addAttribute("dto", vo);
			return "board/change";
		}
	}	

	// 掲示物の削除
	@RequestMapping("delete.do")
	public String delete(@RequestParam int bno) throws Exception {
		boardService.delete(bno);
		return "redirect:list.do";
	}
}
