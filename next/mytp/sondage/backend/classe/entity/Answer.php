<?php

/**
 * Description of Answer
 *
 * @author lnoiro
 */
class Answer {
    
     protected $id_answer;
     protected $id_question;
     protected $libel;
     protected $u_id;
     
     function getId_answer() {
         return $this->id_answer;
     }

     function getId_question() {
         return $this->id_question;
     }

     function getLibel() {
         return $this->libel;
     }

     function getU_id() {
         return $this->u_id;
     }

     function setId_answer($id_answer) {
         $this->id_answer = $id_answer;
     }

     function setId_question($id_question) {
         $this->id_question = $id_question;
     }

     function setLibel($libel) {
         $this->libel = $libel;
     }

     function setU_id($u_id) {
         $this->u_id = $u_id;
     }


}
