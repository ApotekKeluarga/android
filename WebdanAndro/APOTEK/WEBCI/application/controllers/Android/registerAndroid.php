<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class registerAndroid extends CI_Controller {

	function __construct(){
		parent::__construct();
		$this->load->model('M_user');
		$this -> model = $this -> M_user;
		$this -> load -> database();
		$this -> load -> helper('url');
	}

	public function index()
	{
		header("Access-Control-Allow-Origin: *");
  		header("Content-Type: application/json; charset=UTF-8");
		$nama_depan = $this -> input -> post ('Nm_Depan');
		$nama_belakang = $this -> input -> post ('Nm_Belakang');
		$no_telp = $this -> input -> post ('No_Telp');
		$tgl_lahir = $this -> input -> post ('Tgl_Lahir');
		$jk = $this -> input -> post ('JK');
		$email = $this -> input -> post ('Email');
		$password = $this -> input -> post ('Pass');
		$ulangi_password = $this -> input -> post ('Ulangi_Pass');
		$data = array('kd_user' => $this->session->userdata('kd_user'),
		'Nm_Depan' => $nama_depan,
		'Nm_Belakang' => $nama_belakang,
		'No_Telp' => $no_telp,
		'Tgl_Lahir' => $tgl_lahir,
		'JK' => $jk,
		'Email' => $email,
		'Pass' => $password,
		'Ulangi_Pass' => $ulangi_password,

		);
		$insert_data = $this->db->insert('tbl_daftar_akun',$data);
			if ($insert_data) {

				$json = array(
            	'kode' => 1, 
 
            );
 
            	echo json_encode($json);

			 }else{

        		$json = array(
            	'kode' => 2, 
            );
            	echo json_encode($json);
        }
	}
}