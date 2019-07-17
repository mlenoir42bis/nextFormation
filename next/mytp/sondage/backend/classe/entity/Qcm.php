<?php

/**
 * Description of Qcm
 *
 * @author lnoiro
 */

namespace entity;

class Qcm {
    
    protected $id_qcm;
    protected $id_question;
    protected $libel;
    
    function getId_qcm() {
        return $this->id_qcm;
    }

    function getId_question() {
        return $this->id_question;
    }

    function getLibel() {
        return $this->libel;
    }

    function setId_qcm($id_qcm) {
        $this->id_qcm = $id_qcm;
    }

    function setId_question($id_question) {
        $this->id_question = $id_question;
    }

    function setLibel($libel) {
        $this->libel = $libel;
    }


}
