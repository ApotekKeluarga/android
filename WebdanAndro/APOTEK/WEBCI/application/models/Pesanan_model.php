<?php
class Pesanan_model extends CI_Model{
	public $id ='kd_order';
	public $table ='tbl_order';
		function get_pesan(){
			return $this -> db -> query('SELECT * FROM tbl_order ORDER BY kd_order DESC')->result ();
		}
		function get_by_id($id){
			$this -> db -> where($this -> id, $id);
			return $this -> db -> get($this -> table)->row();
		}
}
?>