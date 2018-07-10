<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Web extends CI_Controller {

	public function Dashboard()
	{
		$this->load->view('Home/js');
		$this->load->view('Home/Navbar');
		$this->load->view('Home/Sidebar');
		$this->load->view('Home/Content');
		$this->load->view('Home/Footer');
	}
}
?>