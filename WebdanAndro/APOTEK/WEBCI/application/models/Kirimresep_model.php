<?php
class Kirimresep_model extends CI_Model{
function get_resep(){
		return $this -> db -> query('SELECT * FROM tbl_kirim_resep')->result ();
	}
 
}
?>