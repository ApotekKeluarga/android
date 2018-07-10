<?php 
	
	class Herbal extends CI_Controller{

		function __construct(){
			parent::__construct();      
        	$this->load->model('Dataobat_model');
		}

		public function get_ObatHerbal(){
			header("Access-Control-Allow-Origin: *");
	  		header("Content-Type: application/json; charset=UTF-8");
	        $data = $this->Dataobat_model->get_dataobatkat(11);
	        $dataobat = array();
	        foreach ($data as $obat) {
	            $obat = array(
	                "kd_barang" => $obat->kd_barang,
	                "nm_barang" => $obat->nm_barang,
	                "kd_kategori" => $obat->kd_kategori = 11,
	                "img" => base_url()."assets/images/".$obat->img,
	                "harga" => $obat->harga
	            );
	            array_push($dataobat, $obat);
	        }
	        echo json_encode(array("herbal"=>$dataobat));    
    	}

    	public function get_ObatSuplemen(){
    	$data = $this->Dataobat_model->get_dataobatkat(12);
        $dataobat = array();
        foreach ($data as $obat) {
            $obat = array(
                "kd_barang" => $obat->kd_barang,
                "nm_barang" => $obat->nm_barang,
                "kd_kategori" => $obat->kd_kategori = 12,
                "img" => base_url().$obat->img,
                "harga" => $obat->harga
            );
            array_push($dataobat, $obat);
        }
        echo json_encode(array("suplemen"=>$dataobat));    
    	}

    	public function get_ObatAntibiotik(){
    	$data = $this->Dataobat_model->get_dataobatkat(13);
        $dataobat = array();
        foreach ($data as $obat) {
            $obat = array(
                "kd_barang" => $obat->kd_barang,
                "nm_barang" => $obat->nm_barang,
                "kd_kategori" => $obat->kd_kategori = 13,
                "img" => base_url()."assets/images/".$obat->img,
                "harga" => $obat->harga
            );
            array_push($dataobat, $obat);
        }
        echo json_encode(array("antibiotik"=>$dataobat));	
    	}

    	public function get_ObatAnak(){
    	$data = $this->Dataobat_model->get_dataobatkat(14);
        $dataobat = array();
        foreach ($data as $obat) {
            $obat = array(
                "kd_barang" => $obat->kd_barang,
                "nm_barang" => $obat->nm_barang,
                "kd_kategori" => $obat->kd_kategori = 14,
                "img" => base_url()."assets/images/".$obat->img,
                "harga" => $obat->harga
            );
            array_push($dataobat, $obat);
        }
        echo json_encode(array("anak"=>$dataobat));
    	}

		public function get_AlatKes(){
    	$data = $this->Dataobat_model->get_dataobatkat(15);
        $dataobat = array();
        foreach ($data as $obat) {
            $obat = array(
                "kd_barang" => $obat->kd_barang,
                "nm_barang" => $obat->nm_barang,
                "kd_kategori" => $obat->kd_kategori = 15,
                "img" => base_url()."assets/images/".$obat->img,
                "harga" => $obat->harga
            );
            array_push($dataobat, $obat);
        }
        echo json_encode(array("alkes"=>$dataobat));
		}
	}

?>