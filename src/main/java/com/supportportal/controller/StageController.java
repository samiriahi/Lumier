package com.supportportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.supportportal.entity.Stage;
import com.supportportal.service.StageService;



@RestController
@RequestMapping("/stages")
public class StageController {

    @Autowired
    private StageService stageService;

    @GetMapping("/getall")
    public List<Stage> getAllStages() {
        return stageService.getAllStages();
    }

    @GetMapping("getone/{idStage}")
    public Stage getStageById(@PathVariable Long idStage) {
        return stageService.getStageById(idStage);
    }

    @PostMapping("/add")
    public Stage saveStage(@RequestBody Stage stage) {
        return stageService.saveStage(stage);
    }

    @PutMapping("update/{idStage}")
    public Stage updateStage(@PathVariable Long idStage, @RequestBody Stage stage) {
        // Implement logic to update existing stage (consider setting the ID of the stage object)
        stage.setIdStage(idStage);
        return stageService.saveStage(stage);
    }

    @DeleteMapping("delete/{idStage}")
    public void deleteStage(@PathVariable Long idStage) {
        stageService.deleteStage(idStage);
    }
}