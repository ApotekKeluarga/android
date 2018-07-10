<?php
defined('BASEPATH') OR exit('No direct script access allowed');
class News extends CI_Controller {
function __construct(){
		parent ::__construct();
		$this -> load -> model ('News_model');
		$this -> model = $this -> News_model;
		$this -> load -> database();
		$this -> load -> helper('url');
	}
	public function index()
	{
		$data = array(
			'data_news'=> $this -> News_model -> get_news(),
		);
		$this->load->view('News/News',$data);
	}

	function tambah_berita(){
		$this->load->view('News/Tambah_news');
	}
	public function create(){
        if(isset($_POST['btnSubmit'])){
        	$config = array('upload_path' => './assets/web/base/images/',
        					'allowed_types' => 'gif|jpg|png'
        					);
        	$this -> load -> library ('upload',$config);
        	if ($this->upload->do_upload('img'))
    		{
        		$upload_data = $this -> upload -> data ();
        		$judul = $this -> input -> post ('judul');
        		$foto = "assets/web/base/images/".$upload_data['file_name'];
				$data = array(
				'kd_user_admin' => $this->session->userdata('kd_user_admin'),
				'judul' => $judul,
				'img' => $foto
				);
				$insert_data = $this->db->insert('tbl_news',$data);
			}
			if ($insert_data) {
				redirect(base_url().'index.php/News');
			 } else{
				echo "string";
			 }
		}else{
			echo "string1";
		}
    }
    public function edit($id){
		$row = $this -> News_model -> get_by_id($id);
		$this -> load -> library('encrypt');
		if($row){
			$data = array(
				'kd_news' => $row -> kd_news,
				'judul' => $row -> judul,
				'img' => $row -> img,
			);
			$this -> load -> view('News/Edit_news',$data);
		}
		else{
			redirect(base_url().'News');
		}
	}
	public function editaction(){
		$config = array('upload_path' => './assets/web/base/images/',
        					'allowed_types' => 'gif|jpg|png'
        					);
        $this -> load -> library ('upload',$config);
        $judul = $this -> input -> post('judul');
        if($_FILES['img']['tmp_name']!=NULL){
        	if($this -> upload -> do_upload('img')){
        		$upload_data = $this -> upload -> data();
        		$row = $this -> News_model -> get_by_id($this -> input -> post('id'));
        		unlink($row -> img);
        		$data = array(
        			'judul' => $judul,
        			'img' => "assets/web/base/images/".$upload_data['file_name'],
        		);
        		$res = $this -> News_model -> update ($this -> input -> post('id'),$data);
        		if ($res >= 0) {
        			header('location:'.base_url().'index.php/News');
        		}
        	}
        }else{
        	$data = array(
        			'judul' => $judul,
        			'isi' => $isi,
        		);
        		$res = $this -> News_model -> update ($this -> input -> post('id'),$data);
        		if ($res >= 0 ) {
        			header('location:'.base_url('index.php/News'));
        		}
        }
	}
	public function hapus($id){
		$res = $this -> News_model -> delete($id);
		if($res){
		header('location:'.base_url('index.php/News'));
		}
		else{
			header('location:'.base_url('index.php/News'));
		}
	}
}
