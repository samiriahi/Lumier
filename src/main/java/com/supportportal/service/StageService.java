package com.supportportal.service;

import java.util.List;

import com.supportportal.entity.Stage;



public interface StageService {

    List<Stage> getAllStages();

    Stage getStageById(Long idStage);

    Stage saveStage(Stage stage);

    void deleteStage(Long idStage);
}