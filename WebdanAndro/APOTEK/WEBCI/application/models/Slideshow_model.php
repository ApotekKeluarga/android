<?php
	class Slideshow_model extends CI_Model{ 
		public $id ='kd_slideshow';
		public $table ='tbl_slideshow';
		function get_slideshow(){
			return $this->db->query('SELECT * FROM tbl_slideshow ORDER BY kd_slideshow DESC')->result();
		}
		function insert(){
		$sql = sprintf("INSERT INTO tbl_tips VALUES ('%s')",
			$this -> img);
		$this -> db -> query($sql);
		}
		function get_by_id($id){
			$this -> db -> where($this -> id, $id);
			return $this -> db -> get($this -> table)->row();
		}
		function update($id,$data){
			$this->db->where($this->id, $id);
			$this->db->update($this->table, $data);
		}
		function delete($id){
			$this->db->where($this->id, $id);
			$this->db->delete($this->table);
		}
	}
?>