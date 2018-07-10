<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Kirim_resep extends CI_Controller {
function __construct(){
		parent ::__construct();
		$this -> load -> model ('Kirimresep_model');
	}
	public function index()
	{
		$data = array('data_resep'=> $this -> Kirimresep_model -> get_resep(),);
		$this->load->view('Kirim/Kirimresep',$data);
	}
}
