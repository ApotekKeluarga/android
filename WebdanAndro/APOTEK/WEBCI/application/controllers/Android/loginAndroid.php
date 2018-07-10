<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class loginAndroid extends CI_Controller {

    function __construct(){
        parent::__construct();      
        $this->load->model('M_user');
 
    }
 
    function index(){
    	header("Access-Control-Allow-Origin: *");
  		header("Content-Type: application/json; charset=UTF-8");
       	$username = $this->input->post('Email');
        $password = $this->input->post('Pass');
        $where = array(
            'Email' => $username,
            'Pass' => $password
            );
        $cek = $this->M_user->cek_login("tbl_daftar_akun",$where)->num_rows();
        $cek2 = $this->M_user->cek_login("tbl_daftar_akun",$where)->row();
        if($cek > 0){
 
            $data_session = array(
                'kd_user'   => $cek2->kd_user,
                'nama' => $cek2->Nm_Depan,
                'nama2' => $cek2->Nm_Belakang,
                'no_telp' => $cek2->No_Telp,
                'tgl_lahir' => $cek2->Tgl_Lahir,
                'jeniskel' => $cek2->JK,
                'email' => $username,
                'status' => "login"
                );
 
            $this->session->set_userdata($data_session);

            $json = array(
            	'kode' => 1, 
            	'data' => $data_session
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
