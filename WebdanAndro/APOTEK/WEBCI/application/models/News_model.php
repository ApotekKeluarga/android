<?php
class News_model extends CI_Model{
	public $id ='kd_news';
	public $table ='tbl_news';

	function get_news(){
		return $this -> db -> query('SELECT * FROM tbl_news ORDER BY kd_news DESC')->result ();
	}
	function insert(){
		$sql = sprintf("INSERT INTO tbl_news VALUES ('%s',%f')",
		$this -> judul,
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