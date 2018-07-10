<?php $this->load->view('Home/js'); ?>
<?php $this->load->view('Home/Navbar'); ?>
<?php $this->load->view('Home/Sidebar'); ?>
</div>
 <!-- Page -->
  <div class="page">
    <div class="page-header">
      <h1 class="page-title">Data SlidShow</h1>
      <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="http://localhost/WeBb/WEBCI/index.php/Web/Dashboard">Dashoard</a></li>
        <li class="breadcrumb-item active">Data SlideShow</li>
      </ol>
    </div>

<?php $this->load->view('Search'); ?>
      <!-- Panel Table Add Row -->
      <div class="panel">
        <div class="panel-body">
          <div class="row">
            <div class="col-md-6">
              <div class="mb-15">
                <a href="<?php echo base_url() ?>index.php/Slideshow/tambah_slideshow" id="addToTable" class="btn btn-primary" type="button">
                  <i class="icon md-plus" aria-hidden="true"></i>Tambah SlideShow
                </a>
              </div>
            </div>
          </div>
          <div class="table-responsive"></div>
        <table class="table table-bordered" width="100%" cellspacing="0">
          <thead class="bg-light">
            <tr>
              <th>No.</th>
              <th>Images</th>
              <th width="115px">Action</th>
            </tr>
        </thead>
            <tbody>
              <?php 
              $no =1;
                foreach ($data_slideshow as $slide) {?>
                <tr>
                  <td><?php echo $no++ ?></td>
                  <td><img src="<?php echo base_url().$slide -> img ?>" width="100" height="100"></td>
                  <td><a href="<?php echo base_url('index.php/Slideshow/edit/'.$slide -> kd_slideshow) ?>" class="btn btn-sm btn-icon btn-pure btn-default on-default edit-row waves-effect waves-classic" data-toggle="tooltip" data-original-title="Edit"><i class="icon md-edit" aria-hidden="true" onclick="javascript: return confirm('Anda Yakin Akan Mengubah Data ?')"></i></a>
                    <a href="<?php echo base_url('index.php/Slideshow/hapus/'.$slide->kd_slideshow) ?>" class="btn btn-sm btn-icon btn-pure btn-default on-default remove-row waves-effect waves-classic" data-toggle="tooltip" data-original-title="Remove" onclick="javascript: return confirm('Anda Yakin Akan Menghapus ?')"><i class="icon md-delete" aria-hidden="true"></i></a></td>
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