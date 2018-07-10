<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Awal extends CI_Controller {

    function __construct(){
        parent::__construct();      
        $this->load->model('M_user');
 
    }
 
    function index(){
        $this->load->view('home');
    }
 
    function aksi_login(){
        $username = $this->input->post('Email');
        $password = $this->input->post('Password');
        $where = array(
            'Email' => $username,
            'Password' => $password
            );
        $cek = $this->M_user->cek_login("tbl_user_admin",$where)->num_rows();
        $cek2 = $this->M_user->cek_login("tbl_user_admin",$where)->row();
        if($cek > 0){
 
            $data_session = array(
                'kd_user_admin'   => $cek2->kd_user_admin,
                'nama' => $username,
                'status' => "login"
                );
 
            $this->session->set_userdata($data_session);
 
            redirect(base_url("index.php/Web/Dashboard"));
 
        }else{
            echo "Username dan password salah !";
        }
    }
 
    function logout(){
        $this->session->sess_destroy();
        redirect(base_url('index.php'));
    }
}
