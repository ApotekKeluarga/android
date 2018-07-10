<?php
	class Kategori_model extends CI_Model{
	public $id ='kd_kategori';
	public $table ='kategori'; 
		function get_kategori(){
			return $this->db->query('SELECT * FROM kategori ORDER BY kd_kategori DESC')->result();
		}
		function insert(){
		$sql = sprintf("INSERT INTO kategori VALUES ('%s')",
			$this -> nm_kategori);
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