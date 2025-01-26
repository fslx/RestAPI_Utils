import unittest
from unittest.mock import patch, Mock
from api_client_utilities.main import make_request

class TestApiClient(unittest.TestCase):
    @patch("api_client_utilities.main.requests.get")
    def test_get_request(self, mock_get):
        mock_response = Mock()
        mock_response.json.return_value = {"data": "test"}
        mock_response.status_code = 200
        mock_get.return_value = mock_response

        result = make_request("GET", "resource/1")
        self.assertEqual(result, {"data": "test"})
        mock_get.assert_called_once_with(
            "http://your-api-endpoint.com/api/resource/1",
            headers={"Content-Type", "application/json"}
        )
    @patch("api_client.main.requests.post")
    def test_post_request(self, mock_post):
        mock_response = Mock()
        mock_response.json.return_value = {"success": True}
        mock_response.status_code = 201
        mock_post.return_value = mock_response

        result = make_request("POST", "resource", {"name": "Test"})
        self.assertEqual(result, {"success": True})
        mock_post.assert_called_once_with(
            "https://your-api-endpoint.com/api/resource",
            headers={"Content-Type": "application/json"},
            json={"name": "Test"}
        )

    @patch("api_client.main.requests.put")
    def test_put_request(self, mock_put):
        mock_response = Mock()
        mock_response.json.return_value = {"updated": True}
        mock_response.status_code = 200
        mock_put.return_value = mock_response

        result = make_request("PUT", "resource/1", {"name": "Updated"})
        self.assertEqual(result, {"updated": True})
        mock_put.assert_called_once_with(
            "https://your-api-endpoint.com/api/resource/1",
            headers={"Content-Type": "application/json"},
            json={"name": "Updated"}
        )

    @patch("api_client.main.requests.delete")
    def test_delete_request(self, mock_delete):
        mock_response = Mock()
        mock_response.json.return_value = {"deleted": True}
        mock_response.status_code = 200
        mock_delete.return_value = mock_response

        result = make_request("DELETE", "resource/1")
        self.assertEqual(result, {"deleted": True})
        mock_delete.assert_called_once_with(
            "https://your-api-endpoint.com/api/resource/1",
            headers={"Content-Type": "application/json"}
        )

if __name__ == "__main__":
    unittest.main()
