<?php
	class Tips_kesehatan extends CI_Model{ 
		public $id ='kd_tips';
		public $table ='tbl_tips';
		function get_tips(){
			return $this->db->query('SELECT * FROM tbl_tips ORDER BY kd_tips DESC')->result();
		}
		function insert(){
		$sql = sprintf("INSERT INTO tbl_tips VALUES ('%s','%s','%f')",
			$this -> judul,
			$this -> isi,
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