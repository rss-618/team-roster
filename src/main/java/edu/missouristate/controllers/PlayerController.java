package edu.missouristate.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.missouristate.model.Player;
import edu.missouristate.services.PlayerService;
import edu.missouristate.util.Helper;
import edu.missouristate.util.ModelHelper;

@Controller
public class PlayerController {

	@Autowired
	PlayerService playerService;
	ModelHelper flashmessage;
	
	@GetMapping("/players")
	public String getPlayerTable(Model model, HttpServletRequest request, HttpSession session) {
		List<Player> playerList = playerService.getPlayers();
		
		
		model.addAttribute("playerList", playerList);
		model.addAttribute("title", "Players");
		return "players";
	}
	
	@GetMapping("/players/addEditPlayer")
	public String getAddEditPlayer(HttpSession session, Model model, String id) {
		String page;
		if (Helper.isInteger(id)) {
			page = playerService.prepareEditPlayer(session, model, Integer.parseInt(id));
		} else {
			page = playerService.prepareAddPlayer(model);
		}
		return page;
	}

	@PostMapping("/players/addEditPlayer")
	public String postAddEditPlayer(HttpSession session, Model model, Player player, final RedirectAttributes redirectAttributes) {
		
		if (player != null && player.getId() != null) {
			playerService.updatePlayer(model, player);
			ModelHelper.addFlashMessageToModel(redirectAttributes, ModelHelper.MESSAGE_TYPE_SUCCESS, 
					"Success editing player.");
		}
		else if(player != null && player.getId() == null) {
			playerService.addPlayer(player);
			ModelHelper.addFlashMessageToModel(redirectAttributes, ModelHelper.MESSAGE_TYPE_SUCCESS, 
					"Success adding player.");
		}
		else {
			Helper.addSessionMessage(session, "Could not find player.");
			ModelHelper.addFlashMessageToModel(redirectAttributes, ModelHelper.MESSAGE_TYPE_ERROR, 
					"Sorry, could not find player.");
			
		}
		return "redirect:/players";
	}
	
	@GetMapping("/players/deletePlayer")
	public String getDeletePlayer(HttpSession session, Model model, String id, final RedirectAttributes redirectAttributes) {
		
		if (Helper.isInteger(id)) {
			int deleteCount = playerService.deletePlayer(model, Integer.parseInt(id));
			Helper.addSessionMessage(session, "Records Deleted: " + deleteCount);
			ModelHelper.addFlashMessageToModel(redirectAttributes, ModelHelper.MESSAGE_TYPE_SUCCESS, 
					"Success deleting player.");
		} else {
			String idString = ((id == null) ? "''" : ("'"+id+"'"));
			
			Helper.addSessionMessage(session, "Sorry, could not find player with id = " + idString);
			ModelHelper.addFlashMessageToModel(redirectAttributes, ModelHelper.MESSAGE_TYPE_ERROR, 
					"Failure Deleting Player.");
		}
		
		return "redirect:/players";
	}
}
