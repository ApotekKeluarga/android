<?php $this->load->view('Home/js'); ?>
<?php $this->load->view('Home/Navbar'); ?>
<?php $this->load->view('Home/Sidebar'); ?>
</div>
 <!-- Page -->
  <div class="page">
    <div class="page-header">
      <h1 class="page-title">Tambah Data Tips Kesehatan</h1>
      <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="http://localhost/WeBb/WEBCI/index.php/Web/Dashboard">Dashboard</a></li>
        <li class="breadcrumb-item"><a href="http://localhost/WeBb/WEBCI/index.php/TipsController">Data Tips Kesehatan</a></li>
        <li class="breadcrumb-item active">Tambah Data Tips Kesehatan</li>
      </ol>
    </div>

    <!-- awal page content -->
    <div class="page-content">
      <div class="panel">
            <div class="card-body">
              <form autocomplete="off" method="post" action="<?php echo base_url(). 'index.php/TipsController/create'; ?>" enctype="multipart/form-data">
                <div class="col-md-10 ">
                    <h4 class="example-title">Judul</h4>
                    <input type="text" class="form-control" name="judul" placeholder="Masukkan Judul Tips">
                </div>
                <div class="col-md-10 ">
                    <h4 class="example-title">Deskripsi</h4>
                    <textarea class="form-control" name="isi" rows="3" placeholder="Masukkan Tips"></textarea>
                </div>
              <div class="col-md-6 col-lg-4">
                <h4 class="example-title">Masukkan Gambar</h4>
                <div class="example">
                  <input type="file" class="dropify-event" name="img" accept="images/*" required>
                </div>
              
                <div class="form-group form-material floating" data-plugin="formMaterial">
                  <div class="input-group">
                    <span class="input-group-btn">
                      <button class="btn btn-info" type="submit" name="btnSubmit">Simpan</button>
                    </span>
                  </div>
                </div>
                </div>
              </form>
            </div>
          </div>
    </div>
    <!-- akhir page content -->
  </div>
  <!-- End Page -->

<?php $this->load->view('Home/Footer'); ?>