<?php

/**
 * Description of Survey
 *
 * @author lnoiro
 */

namespace entity;

class Survey {
    
    protected $id_survey;
    protected $id_user;
    protected $title;
    protected $description;
    
    function getId_survey() {
        return $this->id_survey;
    }

    function getId_user() {
        return $this->id_user;
    }

    function getTitle() {
        return $this->title;
    }

    function getDescription() {
        return $this->description;
    }

    function setId_survey($id_survey) {
        $this->id_survey = $id_survey;
    }

    function setId_user($id_user) {
        $this->id_user = $id_user;
    }

    function setTitle($title) {
        $this->title = $title;
    }

    function setDescription($description) {
        $this->description = $description;
    }


}
