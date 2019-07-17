<?php

/**
 * Description of Question
 *
 * @author lnoiro
 */

namespace entity;

class Question {
    
    protected $id_question;
    protected $id_survey;
    protected $type_question;
    protected $libel;
    protected $order_question;
    
    function getOrder_question() {
        return $this->order_question;
    }

    function setOrder_question($order_question) {
        $this->order_question = $order_question;
    }
         
    function getId_question() {
        return $this->id_question;
    }

    function getId_survey() {
        return $this->id_survey;
    }

    function getType_question() {
        return $this->type_question;
    }

    function getLibel() {
        return $this->libel;
    }

    function setId_question($id_question) {
        $this->id_question = $id_question;
    }

    function setId_survey($id_survey) {
        $this->id_survey = $id_survey;
    }

    function setType_question($type_question) {
        $this->type_question = $type_question;
    }

    function setLibel($libel) {
        $this->libel = $libel;
    }


}
