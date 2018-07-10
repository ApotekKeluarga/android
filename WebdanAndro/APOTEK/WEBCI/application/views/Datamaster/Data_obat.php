<?php $this->load->view('Home/js'); ?>
<?php $this->load->view('Home/Navbar'); ?>
<?php $this->load->view('Home/Sidebar'); ?>
</div>
 <!-- Page -->
  <div class="page">
    <div class="page-header">
      <h1 class="page-title">Data Obat</h1>
      <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="http://192.168.43.70/APOTEK/WEBCI/index.php/Web/Dashboard">Dashboard</a></li>
        <li class="breadcrumb-item active">Data Obat</li>
      </ol>
    </div>

   <?php $this->load->view('Search'); ?>
      <!-- Panel Table Add Row -->
      <div class="panel">
        <header class="panel-heading">
        </header>
        <div class="panel-body">
          <div class="row">
            <div class="col-md-6">
              <div class="mb-15">
                <a href="<?php echo base_url() ?>index.php/Data_obat/tambah_obat" id="addToTable" class="btn btn-primary" type="button">
                  <i class="icon md-plus" aria-hidden="true"></i> Tambah Obat
                </a>
              </div>
            </div>
          </div>
          <div class="table-responsive"></div>
		    <table class="table table-bordered" width="100%" cellspacing="0">
		      <thead class="bg-light">
			      <tr>
			        <th>No.</th>
			        <th>Nama</th>
			        <th>Kategori</th>
			        <th>Komposisi</th>
			        <th>Indikasi</th>
			        <th>Dosis</th>
              <th>Penyajian</th>
              <th>Kemasan</th>
			        <th>Harga</th>
			        <th>Deskripsi</th>
			        <th>Stok</th>
			        <th>Gambar</th>
			        <th width="115px">Action</th>
			      </tr>
		    </thead>
            <tbody>
               <?php 
               $no = 1;
                foreach ($data_obat as $obat) {?>
                <tr>
                  <td><?php echo $no++?></td>
                  <td><?php echo $obat-> nm_barang?></td>
                  <td><?php echo $obat-> kd_kategori?></td>
                  <td><?php echo $obat-> komposisi?></td>
                  <td><?php echo $obat-> indikasi?></td>
                  <td><?php echo $obat-> dosis?></td>
                  <td><?php echo $obat-> penyajian?></td>
                  <td><?php echo $obat-> kemasan?></td>
                  <td><?php echo $obat-> harga?></td>
                  <td><?php echo $obat-> deskripsi?></td>
                  <td><?php echo $obat-> stok?></td>
                  <td><img src="<?php echo base_url().$obat -> img ?>" width="100" height="100"></td>
                  <td>
                    <a href="<?php echo base_url('index.php/Data_obat/edit/'.$obat -> kd_barang) ?>" class="btn btn-sm btn-icon btn-pure btn-default on-default edit-row waves-effect waves-classic" data-toggle="tooltip" data-original-title="Edit"><i class="icon md-edit" aria-hidden="true" onclick="javascript: return confirm('Anda Yakin Akan Mengubah Data ?')"></i>
                    <a href="<?php echo base_url('index.php/Data_obat/hapus/'.$obat-> kd_barang) ?>" class="btn btn-sm btn-icon btn-pure btn-default on-default remove-row waves-effect waves-classic" data-toggle="tooltip" data-original-title="Remove"><i class="icon md-delete" aria-hidden="true" onclick="javascript: return confirm('Anda Yakin Akan Menghapus ?')"></i></a></td></td>
                </tr>
            <?php
                }
            ?>
            </tbody>
          </table>
        </div>
      </div>
      <!-- End Panel Table Add Row -->   

    </div>
  </div>
  <!-- End Page -->

<?php $this->load->view('Home/Footer'); ?>