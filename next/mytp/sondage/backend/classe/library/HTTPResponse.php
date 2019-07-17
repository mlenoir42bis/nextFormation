<?php

namespace library;

class HTTPResponse {
    
  public function redirect($location)
  {
    header('Location: '.$location);
    die();
  }
 
}

