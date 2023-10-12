<?php
include_once($_SERVER['DOCUMENT_ROOT'] . "/WebProjectTU/database/index.php");
include_once($_SERVER['DOCUMENT_ROOT'] . "/WebProjectTU/services/position.service.php");

$data = [["name" => "name", "type" => "text"]];
$resource_name = "position";

include($_SERVER['DOCUMENT_ROOT'] . "/WebProjectTU/views/templates/create.php");

if (isset($_POST["create"])) {
    $name = $_POST["name"];

    $position_service = new PositionService($pdo);
    $position = $position_service->create($name);
}

?>