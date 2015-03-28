package nz.co.qt.web.controller;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import nz.co.qt.domain.Category;
import nz.co.qt.domain.Challenge;
import nz.co.qt.domain.ChallengeDetails;
import nz.co.qt.service.CategoryService;
import nz.co.qt.service.ChallengeService;
import nz.co.qt.vo.ChallengeVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 */
@Controller
public class ChallengeController {

	@Autowired
	private ChallengeService challengeService;
	@Autowired
	private CategoryService categoryService;

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	@RequestMapping(value = "/challenge/{challengeId}", method = RequestMethod.GET)
	public String viewChallenge(Map<String, Object> model,
			@PathVariable("challengeId") Long challengeId) {
		Challenge challenge = challengeService.findChallengeById(challengeId);
		ChallengeVO challengeVO = new ChallengeVO();
		challengeVO.setChallenge(challenge);
		if(challenge.getChallengeMetadata() != null){
			challengeVO.setCategoriesIDs(challenge.getChallengeMetadata()
				.getCategoriesIDs());
		}

		model.put("challengeVO", challengeVO);
		return "challenge/viewChallenge";
	}

	@RequestMapping(value = "/challenge/{challengeId}/edit", method = RequestMethod.GET)
	public String getEditChallenge(Map<String, Object> model,
			@PathVariable("challengeId") Long challengeId) {

		Challenge challenge = challengeService.findChallengeById(challengeId);
		ChallengeVO challengeVO = new ChallengeVO();
		challengeVO.setChallenge(challenge);
		if(challenge.getChallengeMetadata() != null){
			challengeVO.setCategoriesIDs(challenge.getChallengeMetadata()
				.getCategoriesIDs());
		}
		List<Category> categories = categoryService.findAll();
		model.put("categories", categories);
		model.put("challengeVO", challengeVO);
		return "challenge/editChallenge";
	}

	@RequestMapping(value = "/challenge/{challengeId}/edit", method = RequestMethod.POST)
	public String saveChallenge(Map<String, Object> model,
			@PathVariable("challengeId") Long challengeId,
			@ModelAttribute("challengeVO") ChallengeVO challengeVO,
			BindingResult result) {

		Challenge challenge = challengeService.editChallengeVO(challengeVO,
				challengeId);
		return "redirect:/challenge/" + challenge.getId();
	}

	@RequestMapping(value = "/challenge", method = RequestMethod.GET)
	public String getCreateChallenge(Map<String, Object> model) {
		ChallengeVO challengeVO = new ChallengeVO();
		List<Category> categories = categoryService.findAll();
		model.put("challengeVO", challengeVO);
		model.put("categories", categories);
		return "challenge/newChallenge";
	}

	@RequestMapping(value = "/challenge", method = RequestMethod.POST)
	public String processCreationForm(
			@ModelAttribute("challengeVO") ChallengeVO challengeVO,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<Category> categories = categoryService.findAll();
			model.addAttribute("categories", categories);
			return "/challenge/newChallenge";
		}

		Challenge challenge = this.challengeService.newChallenge(challengeVO);
		return "redirect:/challenge/" + challenge.getId();
	}

	@RequestMapping(value = "/challenge/get-find-challenges", method = RequestMethod.GET)
	public String initFindForm(Map<String, Object> model) {
		model.put("challengeVO", new ChallengeVO());
		return "/challenge/find-challenges";
	}

	@RequestMapping(value = "/challenge/find-challenges", method = RequestMethod.GET)
	public String processFindForm(ChallengeVO challengeVO,
			BindingResult result, Map<String, Object> model) {

		if (challengeVO.getChallenge().getChallengeDetails().getDescription() == null) {
			challengeVO.getChallenge().getChallengeDetails().setDescription("");
		}

		Collection<ChallengeDetails> results = this.challengeService
				.findChallengeDetailsByDesc(challengeVO.getChallenge()
						.getChallengeDetails().getDescription());
		if (results.isEmpty()) {
			result.rejectValue("challenge.challengeDetails.description", "notFound",
					"not found");
			return "/challenge/find-challenges";
		} else if (results.size() == 1) {
			ChallengeDetails challengeDetails = results.iterator().next();
			return "redirect:/challenge/" + challengeDetails.getChallenge().getId();
		} else {
			model.put("selections", results);
			return "/challenge/challengesList";
		}
	}
}
