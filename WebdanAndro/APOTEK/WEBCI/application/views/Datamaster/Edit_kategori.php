<?php $this->load->view('Home/js'); ?>
<?php $this->load->view('Home/Navbar'); ?>
<?php $this->load->view('Home/Sidebar'); ?>
</div>
 <!-- Page -->
  <div class="page">
    <div class="page-header">
      <h1 class="page-title">Edit Kategori</h1>
      <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="http://localhost/WeBb/WEBCI/index.php/Web/Dashboard">Dashboard</a></li>
        <li class="breadcrumb-item"><a href="http://localhost/WeBb/WEBCI/index.php/Kategori">Data Kategori</a></li>
        <li class="breadcrumb-item active">Edit Kategori</li>
      </ol>
    </div>

    <!-- awal page content -->
    <div class="page-content">
      <div class="panel">
            <div class="panel-heading">
              <h3 class="panel-title">Edit Kategori</h3>
            </div>
            <div class="card-body">
              <form autocomplete="off" method="post" action="<?php echo base_url(). 'index.php/Kategori/editaction'; ?>" enctype="multipart/form-data">
                <div class="col-md-10 ">
                    <h4 class="example-title">Kategori</h4>
                    <input type="text" class="form-control" name="nm_kategori" placeholder="Masukkan Kategori" value="<?php echo $nm_kategori; ?>">
                    <input type="hidden" class="form-control" name="id" placeholder="Masukkan Kategori" value="<?php echo $kd_kategori; ?>">
                </div>
                <div class="col-md-6 col-lg-4">
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
    </div>
    <!-- akhir page content -->
  </div>
  <!-- End Page -->

<?php $this->load->view('Home/Footer'); ?>